import React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
import logo from './logoNavBar.png';
import './NavBar.css';

const NavBar = () => {
    return (
        <AppBar position="fixed" style={{ backgroundColor: '#f5f3ea', color: '#1c2c4b', top: "2.6%" }}>
            <Toolbar sx={{ display: 'flex', justifyContent: 'space-between', minHeight: '64px' }}>
                <Box sx={{ display: 'flex', alignItems: 'center', paddingLeft: '7%' }}>
                    <Button component={Link} to="/">
                        <img src={logo} alt="Logo" style={{ maxHeight: '100%', width: 'auto', height: '9vh' }} />
                    </Button>
                </Box>
                <Box sx={{ display: 'flex', alignItems: 'center', paddingRight: '7%', flex: 1, justifyContent: 'flex-end' }}>
                    <Button color="inherit" component={Link} to="/menus">MENUS</Button>
                    <Button color="inherit" component={Link} to="/story">OUR STORY</Button>
                    <Button color="inherit" component={Link} to="/reservation" >RESERVATIONS</Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default NavBar;
