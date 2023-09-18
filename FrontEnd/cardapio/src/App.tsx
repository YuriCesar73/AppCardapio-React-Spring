// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import { useState } from 'react';
import './App.css'
import { Card } from './components/card/card';
import { userFoodData } from './hooks/userFoodData';
import { CreateModal } from './components/create-modal/create-modal';

function App() {
  const { data} = userFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }


  //console.log(data);
  return (
    <div className='container'>
      <h1>Cardápio</h1>
      <div className='card-grid'>
        {data?.map(foodData => 
        <Card price={foodData.price} title={foodData.title} image={foodData.image}></Card>
        )}
        {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
      <button onClick={handleOpenModal}>novo</button>
      </div>
    </div>
  )
}

export default App
