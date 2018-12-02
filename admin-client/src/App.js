import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Layout/Header";
import Footer from "./components/Layout/ControlBar";
import ControlBar from "./components/Layout/ControlBar";
import DeviceList from "./components/DeviceList/DeviceList";
import ControlButtons from "./components/Layout/ControlButtons";
import { BrowserRouter as Router, Route } from "react-router-dom"
import AddDevice from "./components/DeviceList/AddDevice";
import Dashboard from "./components/Dashboard/Dashboard";
import AddDeviceForm from "./components/DeviceList/AddDeviceForm";

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App" >
          <Header />
          <Route exact path="/addDevice" component={AddDevice} />
          <Route exact path="/addDeviceForm" component={AddDeviceForm} />

          <Route exact path="/dashboard" component={Dashboard} />

        </div>
      </Router>
    );
  }
}

export default App;
