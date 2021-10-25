import React from 'react';
import {
    Card,
    CardHeader,
    CardBody,
    CardTitle,
    Table,
    Row,
    Col,
  } from "reactstrap";
function ChatList(){
    return(

    <div className="content">
        <Row>
            <Col md="12">
                <Card>
                <CardHeader>
                    <CardTitle tag="h4">Chating Room List</CardTitle>
                </CardHeader>
                <CardBody>
                    <Table responsive>
                    <thead className="text-primary">
                        <tr>
                        <th>Name</th>
                        <th>NickName</th>
                        <th>Message</th>
                        <th className="text-right">Day</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td>seoul people</td>
                        <td>people11</td>
                        <td>Hello</td>
                        <td className="text-right">2021-09-01</td>
                        </tr>
                        <tr>
                        <td>Minerva Hooper</td>
                        <td>Curaçao</td>
                        <td>Sinaai-Waas</td>
                        <td className="text-right">$23,789</td>
                        </tr>
                        <tr>
                        <td>Sage Rodriguez</td>
                        <td>Netherlands</td>
                        <td>Baileux</td>
                        <td className="text-right">$56,142</td>
                        </tr>
                        <tr>
                        <td>Philip Chaney</td>
                        <td>Korea, South</td>
                        <td>Overland Park</td>
                        <td className="text-right">$38,735</td>
                        </tr>
                        <tr>
                        <td>Doris Greene</td>
                        <td>Malawi</td>
                        <td>Feldkirchen in Kärnten</td>
                        <td className="text-right">$63,542</td>
                        </tr>
                        <tr>
                        <td>Mason Porter</td>
                        <td>Chile</td>
                        <td>Gloucester</td>
                        <td className="text-right">$78,615</td>
                        </tr>
                        <tr>
                        <td>Jon Porter</td>
                        <td>Portugal</td>
                        <td>Gloucester</td>
                        <td className="text-right">$98,615</td>
                        </tr>
                        <tr>
                        <td>Philip Chaney</td>
                        <td>Korea, South</td>
                        <td>Overland Park</td>
                        <td className="text-right">$38,735</td>
                        </tr>
                        <tr>
                        <td>Doris Greene</td>
                        <td>Malawi</td>
                        <td>Feldkirchen in Kärnten</td>
                        <td className="text-right">$63,542</td>
                        </tr>
                        <tr>
                        <td>Mason Porter</td>
                        <td>Chile</td>
                        <td>Gloucester</td>
                        <td className="text-right">$78,615</td>
                        </tr>
                        <tr>
                        <td>Jon Porter</td>
                        <td>Portugal</td>
                        <td>Gloucester</td>
                        <td className="text-right">$98,615</td>
                        </tr>
                    </tbody>
                    </Table>
                </CardBody>
                </Card>
            </Col>
            </Row>
    </div>
    );
}
export default ChatList;