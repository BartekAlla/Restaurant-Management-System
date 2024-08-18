import React from 'react';
import Layout from '../components/Layout/Layout';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';



function HomePage() {


    return (
        <Layout>
            <Container>
                <Typography variant="h4" gutterBottom>
                    Home Page
                </Typography>
            </Container>
        </Layout>
    );
}

export default HomePage;
