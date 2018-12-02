import React from "react";
import PropTypes from "prop-types";
// @material-ui/core components
import withStyles from "@material-ui/core/styles/withStyles";
import Checkbox from "@material-ui/core/Checkbox";
import Tooltip from "@material-ui/core/Tooltip";
import IconButton from "@material-ui/core/IconButton";
import Table from "@material-ui/core/Table";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
// @material-ui/icons
import Edit from "@material-ui/icons/Edit";
import Close from "@material-ui/icons/Close";
import Check from "@material-ui/icons/Check";
// core components
import tasksStyle from "assets/jss/material-dashboard-react/components/tasksStyle.jsx";
import Avatar from "@material-ui/core/Avatar";
import PhoneIcon from "@material-ui/icons/Smartphone";
import Axios from "axios";



class Tasks extends React.Component {
  
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
    const { classes} = this.props;
    return (
      <Table className={classes.table}>
        <TableBody>
          {this.state.devices.map(device => (
            <TableRow key={device} className={classes.tableRow}>
              <TableCell className={classes.tableCell}>
                <Avatar>
                  <PhoneIcon />
                </Avatar>
              </TableCell>
              <TableCell className={classes.tableCell}>
                {device.name}
              </TableCell>
              <TableCell className={classes.tableActions}>
                <Tooltip
                  id="tooltip-top"
                  title="Edit Device"
                  placement="top"
                  classes={{ tooltip: classes.tooltip }}
                >
                  <IconButton
                    aria-label="Edit"
                    className={classes.tableActionButton}
                  >
                    <Edit
                      className={
                        classes.tableActionButtonIcon + " " + classes.edit
                      }
                    />
                  </IconButton>
                </Tooltip>
                <Tooltip
                  id="tooltip-top-start"
                  title="Remove"
                  placement="top"
                  classes={{ tooltip: classes.tooltip }}
                >
                  <IconButton
                    aria-label="Close"
                    className={classes.tableActionButton}
                  >
                    <Close
                      className={
                        classes.tableActionButtonIcon + " " + classes.close
                      }
                    />
                  </IconButton>
                </Tooltip>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    );
  }
}

Tasks.propTypes = {
  classes: PropTypes.object.isRequired,
  tasksIndexes: PropTypes.arrayOf(PropTypes.number),
  tasks: PropTypes.arrayOf(PropTypes.node)
};

export default withStyles(tasksStyle)(Tasks);
