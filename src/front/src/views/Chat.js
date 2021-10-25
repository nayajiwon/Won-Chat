
import "../assets/css/chat.css";
import { Card, CardTitle, CardHeader, CardBody, Row, Col, CardFooter} from "reactstrap";
function Chat(){
    return(

    <div class="content">
        <Row>
            <Col >
            <Card>
                <CardHeader>
                    <CardTitle tag="h1">WebSocket Chat </CardTitle>
                </CardHeader>
                <CardBody>
                    <div id = "messageArea">

                    </div>
                </CardBody>
                <CardFooter>
                <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                    <button type="submit" class="primary">보내기</button> 
                </CardFooter>
            </Card>
             </Col>
        </Row>


        </div>
    )
}
export default Chat;