import ReactDom from "react-dom";
import "./styles.css";

export default function () {
  let counter = 100;

  function getIncCounter() {
    return counter++;
  }

  function getIncrementCounter() {
    const coIntDiv = (
      <div style={{ margin: "50px" }}>
        <h2>{getIncCounter()}</h2>
      </div>
    );
    const rootElem = document.getElementById("root");

    ReactDom.render(coIntDiv, rootElem);
  }

  setInterval(getIncrementCounter, 500);
}
