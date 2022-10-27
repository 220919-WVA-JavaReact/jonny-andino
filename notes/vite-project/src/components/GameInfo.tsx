import { Game } from "../types/UtilityTypes"

export default function GameInfo(props: Game) {
  return (
    <div className="border p-4 m-2 rounded-md">
        <h1 className="text-xl">{props.name}</h1>
        <hr className="my-2"/>
        <p>{props.description}</p>
        <div className="grid gap-4 grid-cols-2">
            {props.images.map(image => <img src={"/assets/" + image} />)}
        </div>
    </div>
  )
}