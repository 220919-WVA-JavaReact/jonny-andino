import { Game } from "../types/UtilityTypes"
import GameInfo from "../components/GameInfo"

export default function Games() {
  const games: Game[] = [
    {
      name: 'Ghost Story (2019)',
      images: ['gs1.gif','gs2.png'],
      description: 'An action adventure game.'
    },
    {
      name: 'Phosphora (2020 - forever)',
      images: ['p1.gif','p2.gif','p3.gif'],
      description: 'My pride and joy. This is not finished but I got a lot of work done on it over the years'
    },
    {
      name: 'Networking test: Ghost Pong',
      images: ['n1.gif','n2.gif'],
      description: ''
    }
  ]
  
  return (
    <div className="text-center">
        {games.map(game => <GameInfo name={game.name} images={game.images} description={game.description}/>)}
    </div>
  )
}