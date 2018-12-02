import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

import Button from "@material-ui/core/Button";
import AddIcon from "@material-ui/icons/Add";
import Icon from "@material-ui/core/Icon";
import DeleteIcon from "@material-ui/icons/Delete";
import NavigationIcon from "@material-ui/icons/Navigation";
import { Link } from "react-router-dom"

const styles = theme => ({
  button: {
    margin: theme.spacing.unit
  },
  extendedIcon: {
    marginRight: theme.spacing.unit
  }
});

export default class ControlBar extends Component {

  
  render() {
    return (

      <div className="pl-4" >
        {
          //--- Control Buttons
        }
        <Button  variant="fab" color="primary" aria-label="Add" href="AddDeviceForm.html">
          <AddIcon />
        </Button>
      </div>

    );
  }
}
