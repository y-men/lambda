import React from 'react';
import { Formik } from 'formik';

const AddDeviceForm = () => (
  <div>
    <h1>My Form</h1>
    <Formik
      initialValues={{ name: 'yaniv', desc:"This is description" ,toggle:true}}
      onSubmit={(values, actions) => {
        setTimeout(() => {
          alert(JSON.stringify(values, null, 2));
          actions.setSubmitting(false);
        }, 1000);
      }}
      render={props => (
        <form onSubmit={props.handleSubmit}>
          <input
            type="text"
            onChange={props.handleChange}
            onBlur={props.handleBlur}
            value={props.values.name}
            name="name"
          />
          <input
            type="text"
            onChange={props.handleChange}
            onBlur={props.handleBlur}
            value={props.values.desc}
            name="desc"
          />
          <input
          type="checkboxude"
          onChange={props.handleChange}
          onBlur={props.handleBlur}
          value={props.values.toggle}
          name="toggle"
        />
          {props.errors.name && <div id="feedback">{props.errors.name}</div>}
          <button type="submit">Submit</button>
        </form>
      )}
    />
  </div>
);
export default AddDeviceForm;