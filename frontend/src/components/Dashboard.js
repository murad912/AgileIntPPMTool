import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";

class Dashbords extends Component {
  render() {
    return (
      <div>
        <h1 className="alert alert-warning">Welcome to the Dashboard</h1>
        <ProjectItem />
        <ProjectItem />
        <Header />
      </div>
    );
  }
}

export default Dashbords;
