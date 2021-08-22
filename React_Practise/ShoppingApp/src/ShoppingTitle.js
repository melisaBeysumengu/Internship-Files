import react from "react";

function ShoppingTitle(props) {
  return (
    <div>
      <h1>{props.title}</h1>
      <h2>Number of items: {props.numItems}</h2>
    </div>
  );
}

export default ShoppingTitle;
