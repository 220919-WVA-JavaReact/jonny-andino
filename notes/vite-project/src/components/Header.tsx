import { Link } from 'react-router-dom';
import { HyperLink } from "../types/UtilityTypes"

export default function Header() {
    return (
        <header className="p-4 m-2 border rounded-md text-center">
            <p className="text-3xl font-bold p-4">
                Hello.
            </p>
            <nav>
                <ListItem name="About" url="/" />
                <ListItem name="Games" url="/games" />
            </nav>
        </header>
    )
}

const ListItem = (props: HyperLink) => {
    return (
        //<a href={props.url} className="m-2 underline hover:text-violet-400 transition">
            //{props.name}
        //</a>
        <Link to={props.url} className="m-2 underline hover:text-violet-400 transition">
            {props.name}
        </Link>
    )
}