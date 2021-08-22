import ReactDom from "react-dom";

var product = { name: "apple", stock: 0 };

if (product.stock <= 10) {
  var element = <h1>Product named {product.name} is not in the stock.</h1>;
} else {
  var element = (
    <h1>
      Product named {product.name} is in the stock. Stock: {product.stock}
    </h1>
  );
}

ReactDom.render(element, document.getElementById("root"));
