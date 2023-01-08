import * as React from "react";
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import ProductList from "./product/ProductList";

const dataProvider = jsonServerProvider('http://localhost:8080');

const App = () => (
      <Admin dataProvider={dataProvider}>
          <Resource name="product" list={ProductList}/>
     </Admin>
  );

export default App;