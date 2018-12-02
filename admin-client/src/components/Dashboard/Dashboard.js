import React from "react";
import ControlButtons from "../Layout/ControlButtons";
import DeviceList from "../DeviceList/DeviceList";

export default function Dashboard() {
  return (
    <div>
      <ControlButtons />
      <DeviceList />
    </div>
  );
}
