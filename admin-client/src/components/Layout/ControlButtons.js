import React from "react";
import { Link } from "react-router-dom";
import spacing from "@material-ui/core/styles/spacing";

const ControlButtons = () => {
  return (
    <React.Fragment>
    <div className="btn-toolbar pl-4" style={{margin: 4}}>
        <Link to="/addDevice" className=" mx-1 btn btn-lg btn-info">
          Add Device
        </Link>
        <Link to="/addDeviceForm" className=" mx-1 btn btn-lg btn-info">
          Add Device 2
        </Link>
      </div>
    </React.Fragment>
  );
};
export default ControlButtons;
