import { Fact } from "../types/UtilityTypes"

export default function TTALItem(props: Fact){
    const color = (props.isTrue) ? 'hover:border-green-700' : 'hover:border-red-700';
    
    return (
        <div className={'m-2 p-2 border-2 rounded-md ' + color + ' transition'}>
            {props.id}: {props.fact}
        </div>
    )
}