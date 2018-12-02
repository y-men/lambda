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


const styles = theme => ({
    root: {
        width: "100%",
        maxWidth: 360,
        backgroundColor: theme.palette.background.paper
    },

    button: {
        margin: theme.spacing.unit
    },
    extendedIcon: {
        marginRight: theme.spacing.unit
    }
    ,
    listItem:{
        width: "50%",
        maxWidth: 30, 
    }
});


 class Device extends Component {
  render() {
    return (
      <div>
        <ListItem divider="true" style={styles.listItem}>
          <Avatar>
            <PhoneIcon />
          </Avatar>
          <ListItemText primary={this.props.primaryText} secondary={this.props.secondaryText} />
          <ListItemSecondaryAction>
            <Switch />
            <DeleteIcon />
          </ListItemSecondaryAction>
        </ListItem>
      </div>
    );
  }
}


export default withStyles(styles)(Device);

