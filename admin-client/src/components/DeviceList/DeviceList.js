import React, { Component } from "react";

import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Avatar from "@material-ui/core/Avatar";
import PhoneIcon from "@material-ui/icons/Smartphone";
import { ListItemSecondaryAction, Switch } from "@material-ui/core";

import DeleteIcon from "@material-ui/icons/Delete";
import Device from "./Device";
import Axios from "axios";

export default class DeviceList extends Component {
  state = {
    devices: []
  };

  componentDidMount() {
    //TODO How to load from properties
    Axios.get("http://localhost:8080/api/device/list").then(r => {
      const devices = r.data;
      this.setState({ devices });
    });
  }

  render() {
    return (
      // <div className="w-50 p-3 col justify-content-center align-items-center">
      //     <List>
      //         <Device primaryText="My Phone" secondaryText="My primary phone for home use"/>
      //         <Device primaryText="My Work Phone" secondaryText="This is the phne used for work"/>
      //         <Device primaryText="Older Phone" secondaryText="Old phone that is rarely used"/>

      //     </List>
      // </div>
      <div className="w-50 p-3 col justify-content-center align-items-center">
        {this.state.devices.map(device => {
          //console.log("--------------- d: " + device.name)
          return (
            <Device
              primaryText={device.name}
              secondaryText={device.desc}
            />
          );
        })}
      </div>
    );
  }
  A;
}
