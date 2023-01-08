import * as React from "react";
import { List, Datagrid, TextField, EditButton, TextInput, DateInput,SimpleFormIterator,ArrayInput } from 'react-admin';
const invoiceFilters = [
    <TextInput source="description" label="Descriere" alwaysOn />,
    <TextInput source="code" label="Cod" alwaysOn/>
];



export const ProductList = (props) => (

    <List      {...props} filters={invoiceFilters}>
        <Datagrid>
            <TextField source="description" />
            <TextField source="buyPrice" />
            <TextField source="sellPrice" />
            <TextField source="stock" />
            <TextField source="code" />
        </Datagrid>
    </List>
);

export default ProductList;