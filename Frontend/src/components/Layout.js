import React from 'react';
import NavBar from './NavBar';
import Shape from './Shape';
import Box from '@mui/material/Box';

const Layout = ({ children }) => {
    return (
        <Box>
            <Shape>
                <NavBar />
                <Box>
                    {children}
                </Box>
            </Shape>
        </Box>
    );
};

export default Layout;
