import TTALItem from "../components/TTALItem"
import { Fact } from "../types/UtilityTypes"

export default function TTAL() {
    
    const facts: Fact[] = [
        {
            id: 1,
            fact: "I've been to Mars",
            isTrue: false
        },
        {
            id: 2,
            fact: "I know how to play the Piano",
            isTrue: true
        },
        {
            id: 3,
            fact: "This fact is true",
            isTrue: true
        },
    ]

    return (
        <div className="text-center">
            {
                facts.map(fact => <TTALItem id={fact.id} fact={fact.fact} isTrue={fact.isTrue} />)    
            }
        </div>
    )
}