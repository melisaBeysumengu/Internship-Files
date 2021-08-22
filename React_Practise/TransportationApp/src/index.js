import { StrictMode } from "react";
import ReactDOM from "react-dom";

import TransportationApp from "./TransportationApp";

const rootElement = document.getElementById("root");
ReactDOM.render(
  <StrictMode>
    <TransportationApp />
  </StrictMode>,
  rootElement
);
