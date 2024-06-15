
import React from 'react';
import NavBar from './NavBar';
import Shape from './Shape';
import Box from '@mui/material/Box';

const Layout = ({ children }) => {
    return (
        <Box>
            //TODO - hiding nav bar inside shape can be here?
            <NavBar/>
            <Shape>
                {children}
            </Shape>
        </Box>
    );
};

export default Layout;
