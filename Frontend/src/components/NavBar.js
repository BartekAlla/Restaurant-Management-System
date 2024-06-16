import React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
import logo from './logoNavBar.png';

const NavBar = () => {
    return (
        <Box>
            <AppBar position="fixed" style={{ backgroundColor: '#f5f3ea', color: '#1c2c4b', top: "2.6%", height: '10.5%' }}>
                <Toolbar sx={{ display: 'flex', justifyContent: 'space-between', paddingLeft: '5%'}}>
                    <Box sx={{ display: 'flex', alignItems: 'center', height: '100%' }}>
                        <Button component={Link} to="/">
                            <img src={logo} alt="Logo" style={{ maxHeight: '10%', maxWidth: '100%', height: 'auto' }} />
                        </Button>
                    </Box>
                    <Box sx={{ display: 'flex', alignItems: 'center' , paddingRight: '7%' }}>
                        <Button color="inherit" component={Link} to="/menus">MENUS</Button>
                        <Button color="inherit" component={Link} to="/story">OUR STORY</Button>
                        <Button color="inherit" component={Link} to="/reservation">RESERVATIONS</Button>
                    </Box>
                </Toolbar>
            </AppBar>
        </Box>
    );
};

export default NavBar;
