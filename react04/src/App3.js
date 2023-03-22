import { Provider} from 'react-redux';
import Comn1 from './componts/Compont1';
import Comn2 from './componts/Compont2';
import Comn3 from './componts/Compont3';
import Comn4 from './componts/Compont4';
import Comn5 from './componts/Compont5';
import store from './componts/store';


export default function App2() {
  return (
    <Provider store={store}>
        <Comn3/>
        <Comn4/>
        <Comn5/>
    </Provider>
  )
}


