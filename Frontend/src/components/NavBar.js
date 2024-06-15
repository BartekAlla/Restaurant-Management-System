import React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
//TODO - navBar must be inside of Shape not a seperate part of website
const NavBar = () => {
    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar>
                    <Button color="inherit" component={Link} to="/">Home page</Button>
                    <Button color="inherit" component={Link} to="/menu">Menus</Button>
                </Toolbar>
            </AppBar>
        </Box>
    );
};

export default NavBar;
