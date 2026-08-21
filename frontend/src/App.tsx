import { BrowserRouter } from 'react-router-dom';

import AppRoutes from './routes/AppRoutes.tsx';

function App() {
  return (
    <BrowserRouter>
        <AppRoutes></AppRoutes>
    </BrowserRouter>
  )
}

export default App
