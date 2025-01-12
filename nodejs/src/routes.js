const express = require("express");
const router = express.Router();
const {
  createClient,
  listClients,
  sortByAge,
  averageAge,
} = require("./controllers/clientController");

router.post("/clientes", createClient);
router.get("/clientes", listClients);
router.get("/clientes/orden-edad", sortByAge);
router.get("/clientes/promedio-edad", averageAge);

module.exports = router;
