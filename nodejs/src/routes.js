const express = require("express");
const router = express.Router();
const {
  createClient,
  listClients,
  sortByAge,
} = require("./controllers/clientController");

router.post("/clientes", createClient);
router.get("/clientes", listClients);
router.get("/clientes/orden-edad", sortByAge);

module.exports = router;
