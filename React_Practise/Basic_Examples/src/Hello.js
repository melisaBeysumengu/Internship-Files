import ReactDom from "react-dom";

export default function () {
  const nested = (
    <>
      <div>
        <div>Hello world</div>
        <div>Hello world</div>
      </div>
    </>
  );
  return nested;
  //ReactDom.render(nested, document.getElementById("root"));
}
