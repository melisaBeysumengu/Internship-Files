import { StrictMode } from "react";
import ReactDOM from "react-dom";
import ShoppingApp from "./ShoppingApp";

const rootElement = document.getElementById("root");
ReactDOM.render(
  <StrictMode>
    <ShoppingApp />
  </StrictMode>,
  rootElement
);
