import React from "react";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import { makeStyles } from "@material-ui/core/styles";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";

function Filter() {
  return (
    <div>
      <h3>Choose Options</h3>
      {CheckboxLabels()}
      {SimpleSelect()}
    </div>
  );
}
export default Filter;

function CheckboxLabels() {
  const [state, setState] = React.useState({
    checkedB: true
  });

  const handleChange = (event) => {
    setState({ state, [event.target.name]: event.target.checked });
  };

  return (
    <FormControlLabel
      control={
        <Checkbox
          checked={state.checkedB}
          onChange={handleChange}
          name="checkedB"
        />
      }
      labelPlacement="start"
      label="New Only"
    />
  );
}

const useStyles = makeStyles((theme) => ({
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120
  },
  selectEmpty: {
    marginTop: theme.spacing(2)
  }
}));

function SimpleSelect() {
  const classes = useStyles();
  const [option, setOption] = React.useState("");

  const handleChange = (event) => {
    setOption(event.target.value);
  };

  return (
    <div>
      <FormControl variant="outlined" className={classes.formControl}>
        <InputLabel id="demo-simple-select-outlined-label">Select</InputLabel>
        <Select
          labelId="demo-simple-select-outlined-label"
          id="demo-simple-select-outlined"
          value={option}
          onChange={handleChange}
          label="Select"
        >
          <MenuItem value="">
            <em>All</em>
          </MenuItem>
          <MenuItem value={0}>Convertible</MenuItem>
          <MenuItem value={1}>Sedan</MenuItem>
          <MenuItem value={2}>Hatchback</MenuItem>
        </Select>
      </FormControl>
    </div>
  );
}
