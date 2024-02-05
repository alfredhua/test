const { disableEsLint } = require("customize-cra");

const path = require("path");

module.exports = override(
  disableEsLint()
);
