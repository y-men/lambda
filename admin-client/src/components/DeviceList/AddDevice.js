import React, { Component } from "react";
import Axios from "axios";

export default class AddDevice extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "",
      desc: "",
      toggle: false
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    console.log("--------------------------------------");
    const device = {
      name: this.state.name,
      desc: this.state.desc,
      toggle: this.state.toggle
    };
    console.log(device);

    Axios.post("http://localhost:8080/api/device/update", device)
      .then(r => {
        console.log("result:" + r);
      })
      .catch(e => {
        console.log("error: " + e);
      });
  }

  render() {
    return (
      <div>
        {
          // Adding a new device
        }

        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">
                  Create / Edit Device form
                </h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg "
                      placeholder="Device Name"
                      name="name"
                      value={this.state.name}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group">
                    <textarea
                      className="form-control form-control-lg"
                      placeholder="Device Description"
                      name="desc"
                      value={this.state.desc}
                      onChange={this.onChange}
                    />
                  </div>

                  <div className="form-check form-control-lg">
                    <input
                      type="checkbox"
                      className="form-check-input form-control form-control-lg"
                      placeholder=".form-control-lg"
                      id="activeCheck"
                      name="toggle"
                      value={this.state.toggle}
                      onChange={this.onChange}
                    />
                    <label className="form-check-label" for="exampleCheck1">
                      Active
                    </label>
                  </div>
                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
