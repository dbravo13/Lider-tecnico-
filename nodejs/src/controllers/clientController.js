const fs = require("fs");
const path = require("path");

const dbPath = path.join(__dirname, "../data.json");

// Crear cliente
const createClient = (req, res) => {
  const { nombre, documento, email, fechaNacimiento } = req.body;

  if (!nombre || !documento || !email || !fechaNacimiento) {
    return res.status(400).send({ error: "Todos los campos son requeridos" });
  }

  const dateFormat = /^\d{4}-\d{2}-\d{2}$/;
  if (!dateFormat.test(fechaNacimiento)) {
    return res.status(400).send({
      error: "La fecha de nacimiento debe tener el formato YYYY-MM-DD",
    });
  }

  const emailFormat = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  if (!emailFormat.test(email)) {
    return res
      .status(400)
      .send({ error: "El correo electrónico no es válido" });
  }

  try {
    const data = JSON.parse(fs.readFileSync(dbPath, "utf-8"));

    const existingClient = data.find(
      (client) => client.documento === documento || client.email === email
    );

    if (existingClient) {
      return res.status(409).send({
        error: "El documento o el correo electrónico ya están registrados",
      });
    }

    const newClient = { nombre, documento, email, fechaNacimiento };
    data.push(newClient);

    fs.writeFileSync(dbPath, JSON.stringify(data, null, 2));

    res.status(201).send(newClient);
  } catch (error) {
    console.error("Error al leer o escribir el archivo:", error);
    res.status(500).send({ error: "Error al procesar la solicitud" });
  }
};

// Listar clientes
const listClients = (req, res) => {
  const data = JSON.parse(fs.readFileSync(dbPath, "utf-8"));
  const sortedData = data.sort((a, b) => a.nombre.localeCompare(b.nombre));
  res.send(sortedData);
};

// Listar por edad
const sortByAge = (req, res) => {
  const data = JSON.parse(fs.readFileSync(dbPath, "utf-8"));
  const currentDate = new Date();

  const dataWithAge = data.map((client) => {
    const birthDate = new Date(client.fechaNacimiento);
    const age = currentDate.getFullYear() - birthDate.getFullYear();
    return { nombre: client.nombre, edad: age };
  });

  const sortedByAge = dataWithAge.sort((a, b) => a.edad - b.edad);
  res.send(sortedByAge);
};

// Promedio de edad
const averageAge = (req, res) => {
  const data = JSON.parse(fs.readFileSync(dbPath, "utf-8"));
  const currentDate = new Date();

  const ages = data.map((client) => {
    const birthDate = new Date(client.fechaNacimiento);
    return currentDate.getFullYear() - birthDate.getFullYear();
  });

  const totalAge = ages.reduce((acc, age) => acc + age, 0);
  const average = ages.length > 0 ? totalAge / ages.length : 0;

  res.send({ cantidad: ages.length, promedioEdad: average });
};

module.exports = { createClient, listClients, sortByAge, averageAge };
