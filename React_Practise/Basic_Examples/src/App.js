import "./styles.css";
import ReactDom from "react-dom";

export const renderApp = function () {
  const hello = <h1>hello world!</h1>;

  const rootElement = document.getElementById("root");

  ReactDom.render(hello, rootElement);
};

export default renderApp;
