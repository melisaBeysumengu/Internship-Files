import "./styles.css";

function ListItem(props) {
  return <li>{props.items}</li>;
}

function ShoppingList(props) {
  return (
    <div>
      <h3>{props.header}</h3>
      <ul className="reset-style custom-style-base custom-style-hover-color cursor-pointer">
        <ListItem items={props.items[0]} />
        <ListItem items={props.items[1]} />
        <ListItem items={props.items[2]} />
      </ul>
    </div>
  );
}

function ShoppingList2(props) {
  return (
    <div>
      <h3>{props.header}</h3>
      <ol>
        {props.items.map((item) => (
          <li key={item}>{item}</li>
        ))}
      </ol>
    </div>
  );
}

export default ShoppingList2;
