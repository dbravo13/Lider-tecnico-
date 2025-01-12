const express = require("express");
const router = express.Router();
const { createClient, listClients } = require("./controllers/clientController");

router.post("/clientes", createClient);
router.get("/clientes", listClients);

module.exports = router;
