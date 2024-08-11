import React from 'react';
import NavBar from '../NavBar/NavBar';
import Shape from '../Shape/Shape';
import Box from '@mui/material/Box';
import { makeStyles } from '@mui/styles';


//TODO ELEVATE NAV BAR WHILE SCROLLING DOWN

const useStyles = makeStyles(() => ({
    layoutContainer: {
        height: '100vh',
        display: 'flex',
        flexDirection: 'column',
        overflow: 'hidden',
    },
    contentContainer: {
        flex: 1,
        overflowY: 'auto',
        width: '100%',
        marginTop: '11vh',
    },
}));

const Layout = ({ children }) => {
    const classes = useStyles();

    return (

        <Box className={classes.layoutContainer}>
            <Shape>
                <NavBar />
                <Box className={classes.contentContainer}>
                    {children}
                </Box>
            </Shape>
        </Box>
    );
};

export default Layout;
