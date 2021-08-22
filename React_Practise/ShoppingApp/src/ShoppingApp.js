import "./styles.css";
import Title from "./ShoppingTitle";
import SList from "./ShoppingList";

function ShoppingApp(props) {
  return (
    <div>
      <Title title="My Shopping List" numItems="9" />
      <SList header="Food" items={["Apple", "Bread", "Cheese"]} />
      <SList header="Clothes" items={["Shirts", "Pants", "Hat"]} />
      <SList header="Supplies" items={["Pen", "Paper", "Glue"]} />
    </div>
  );
}

export default ShoppingApp;
