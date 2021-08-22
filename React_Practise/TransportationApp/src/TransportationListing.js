import React from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";

function TItem(props) {
  return (
    <div>
      <p>
        Year = {props.year} Model = {props.model} Price = {props.price}
      </p>
    </div>
  );
}

function TransportationListing(props) {
  return (
    <div>
      <h1>{props.name}</h1>
      {BasicTable(props)}
    </div>
  );
}

export default TransportationListing;

function BasicTable(props) {
  const rows = props.list;
  return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Year</TableCell>
            <TableCell align="right">Model</TableCell>
            <TableCell align="right">Price</TableCell>
            <TableCell align="right">Purchase</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.name}>
              <TableCell align="right">{row.year}</TableCell>
              <TableCell align="right">{row.model}</TableCell>
              <TableCell align="right">{row.price}</TableCell>
              <TableCell align="right">
                <button>Buy Now</button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
