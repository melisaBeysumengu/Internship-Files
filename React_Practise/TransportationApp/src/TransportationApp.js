import React from "react";
import TransportationListing from "./TransportationListing";
import Header from "./Header";
import Filter from "./Filter";

function TransportationApp(props) {
  return (
    <>
      <div>
        <Header />
        <Filter />
        <TransportationListing
          name="Cars"
          list={[
            { year: "2013", model: "A", price: "$32000" },
            { year: "2011", model: "B", price: "$4400" },
            { year: "2016", model: "B", price: "$15500" }
          ]}
        />
        <TransportationListing
          name="Trucks"
          list={[
            { year: "2014", model: "D", price: "18000" },
            { year: "2013", model: "E", price: "5200" }
          ]}
        />
      </div>
    </>
  );
}

export default TransportationApp;
