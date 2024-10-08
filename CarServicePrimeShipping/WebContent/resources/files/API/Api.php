<?php
/**
 * Created by PhpStorm.
 * User: Belal
 * Date: 10/5/2017
 * Time: 11:53 AM
 */
 
require_once dirname(__FILE__) . '/FileHandler.php';
 
$response = array();
 
if (isset($_GET['apicall'])) {
    switch ($_GET['apicall']) {
        case 'upload':
            if (isset($_POST['type'])  && isset($_POST['carId']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
                $upload = new FileHandler();
                $file = $_FILES['image']['tmp_name'];
 

                if ($upload->saveFile($_FILES, getFileExtension($_FILES['image']['name']),$_POST['carId'],$_POST['type'])) {
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
					
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
						

            }
 
            break;
			
		case 'uploadImageContainer':
            if (isset($_POST['type'])  && isset($_POST['containerId']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
                $upload = new FileHandler();
                $file = $_FILES['image']['tmp_name'];
 

                if ($upload->saveFileContainer($_FILES, getFileExtension($_FILES['image']['name']),$_POST['containerId'],$_POST['type'])) {
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
					
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
						

            }
 
            break;
			
		case 'uploadSignitureOfDriver':
            if ( isset($_POST['carId']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
                $upload = new FileHandler();
                $file = $_FILES['image'];
 

                if ($upload->saveSigntureOfDriverFile($file, getFileExtension($_FILES['image']['name']),$_POST['carId'])) {
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
					
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
						

            }
 
            break;
			
		case 'uploadSignitureOfDriverDestination':
            if ( isset($_POST['carId']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
                $upload = new FileHandler();
                $file = $_FILES['image'];
 

                if ($upload->saveSigntureOfDriverDestinationFile($file, getFileExtension($_FILES['image']['name']),$_POST['carId'])) {
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
					
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
						

            }
 
            break;
			
		case 'uploadCrashImage':
            if ( isset($_POST['carId']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
                $upload = new FileHandler();
                $file = $_FILES['image'];
 

                if ($upload->saveCrashsFile($_POST['crashPointsJson'],$file, getFileExtension($_FILES['image']['name']),$_POST['carId'])) {
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
					
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
						

            }
 
            break;
 
        case 'getallimages':
 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['images'] = $upload->getAllFiles();
 
            break;
			
		case 'getUserWithNameAndPassword':
			if (isset($_POST['userName']) && strlen($_POST['userName']) > 0 && isset($_POST['password']) && strlen($_POST['password']) > 0){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getUser($_POST['userName'],$_POST['password']);
            echo $reponse['data'];
			}
            break;
			
		case 'getCarData':
			if (isset($_POST['id']) && strlen($_POST['id']) > 0 ){ 
			$upload = new FileHandler();
            $response['error'] = false;
            $response['images'] = $upload->getCarImages($_POST['id']);
            $response['docs'] = $upload->getCarDoc($_POST['id']);
            $response['pdfs'] = $upload->getCarPdf($_POST['id']);
            $response['images3D'] = $upload->getCar3D($_POST['id']);
            $response['data'] = $upload->getCarData($_POST['id']);
            $response['allshippers'] = $upload->getShippersAllData($response['data']['mainId']);
			}
            break;
		
		case 'getContainerData':
			if (isset($_POST['id']) && strlen($_POST['id']) > 0 ){ 
			$upload = new FileHandler();
            $response['error'] = false;
            $response['images'] = $upload->getContainerImages($_POST['id']);
            $response['data'] = $upload->getContainerData($_POST['id']);
			}
            break;
			
		case 'insertNewCar':
		
		$json = file_get_contents('php://input');
		// Converts it into a PHP object
		$data = json_decode($json);
			if($data->mainId == 0)
				$data->mainId = null;
		
			if($data->mainTwoId == 0)
				$data->mainTwoId = null;
		
			if($data->shipperId == 0)
				$data->shipperId = null;
		
			if($data->vendorId == 0)
				$data->vendorId = null;
		
			if($data->customerId == 0)
				$data->customerId = null;
		
			if($data->consigneeId == 0)
				$data->consigneeId = null;
		
			if (isset($data->uuid) && strlen($data->uuid) > 0 ){ 
			$upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->insertNewCar($data->fuelTypePrimary,$data->fuelTypeSecondary,$data->weight,$data->titleExist,$data->keyExist,$data->exteriorExists,$data->companyTransName,$data->exteriorImg,$data->driverName,$data->driverPhone,$data->numberOfKeys,$data->CarType,$data->id,$data->mainId,$data->mainTwoId,$data->shipperId,$data->vendorId,$data->customerId,$data->consigneeId,$data->make,$data->model,$data->year,$data->bodyStyle,$data->engineType,$data->engineLiters,$data->assemlyCountry,$data->color,$data->seacost,$data->landcost,$data->state,$data->releaseOption,$data->stateOut,$data->releaseDate,$data->uuid,$data->description,$data->containerLink,$data->eta,$data->etd);
            
			$response['images'] = $upload->getCarImages($response['data']['id']);
            $response['docs'] = $upload->getCarDoc($response['data']['id']);
            $response['pdfs'] = $upload->getCarPdf($response['data']['id']);
            $response['images3D'] = $upload->getCar3D($response['data']['id']);
            $response['allshippers'] = $upload->getShippersAllData($response['data']['mainId']);
			}
            break;
		

	case 'insertNewContainer':
		
		$json = file_get_contents('php://input');
		// Converts it into a PHP object
		$data = json_decode($json);
			
		
			if (isset($data->container_number) && strlen($data->container_number) > 0 ){ 
			$upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->insertNewContainer($data->id,$data->container_number,$data->description_of_container,$data->datetime);
            
			$response['images'] = $upload->getContainerImages($response['data']['id']);
           
		   
			}
            break;
				
			
		case 'getAllContainersForMainAccount':
			if (isset($_POST['mainId']) && strlen($_POST['mainId']) > 0  && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllContainersForMainAccount($_POST['mainId'],$_POST['page'],$_POST['N_items']);
			}
            break;
			
		case 'getAllCarsForMainAccount':
			if (isset($_POST['mainId']) && strlen($_POST['mainId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForMainAccount($_POST['mainId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
		
			
			
		case 'getAllCarsForMainTwoAccount':
			if (isset($_POST['mainTwoId']) && strlen($_POST['mainTwoId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForMainTwoAccount($_POST['mainTwoId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
			
		case 'getAllCarsForShipperAccount':
			if (isset($_POST['shipperId']) && strlen($_POST['shipperId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForShipperAccount($_POST['shipperId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
			
			
		case 'getAllCarsForVendorAccount':
			if (isset($_POST['vendorId']) && strlen($_POST['vendorId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForVendorAccount($_POST['vendorId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
			
		case 'getAllCarsForCustomerAccount':
			if (isset($_POST['customerId']) && strlen($_POST['customerId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForCustomerAccount($_POST['customerId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
			
		case 'getAllCarsForConsigneeAccount':
			if (isset($_POST['consigneeId']) && strlen($_POST['consigneeId']) > 0 && isset($_POST['type']) && strlen($_POST['type']) > 0 && isset($_POST['page']) && strlen($_POST['page']) > 0 &&isset($_POST['N_items']) && strlen($_POST['N_items']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getAllCarsForConsigneeAccount($_POST['consigneeId'],$_POST['page'],$_POST['N_items'],$_POST['type'],$_POST['date_selected']);
			}
            break;
			
			
		case 'getImageFromUserId':
			if (isset($_POST['userId']) && strlen($_POST['userId']) > 0 ){ 
            $upload = new FileHandler();
            $response['error'] = false;
            $response['data'] = $upload->getImageFromUserId($_POST['userId']);
			}
            break;
    }
}
 

echo json_encode($response);
 
function getFileExtension($file)
{
    $path_parts = pathinfo($file);
    return $path_parts['extension'];
}
