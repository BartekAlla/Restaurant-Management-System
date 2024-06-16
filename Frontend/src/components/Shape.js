import React from 'react';
import Box from '@mui/material/Box';

const Shape = ({children, width = '97%', height = '95%'}) => {
    return (
        <Box
            sx={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '100vh',
                backgroundColor: '#1c2c4b',
                backgroundSize: 'cover',
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'center',
            }}
        >

            <Box
                sx={{
                    width: width,
                    height: height,
                    backgroundColor: '#f5f3ea',
                    clipPath: 'polygon(0% 11%, 5% 0%, 95% 0%, 100% 11%, 100% 95%, 95% 100%, 5% 100%, 0% 95%)',
                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center',
                    textAlign: 'center',
                    padding: '5px',
                }}
            >
                {children}
            </Box>
        </Box>
    );
};

export default Shape;
