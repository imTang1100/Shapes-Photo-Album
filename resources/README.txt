In the final homework of cs5004, I tried to design MVC in these way: 

-Controller: IController 

	This class aims to translate the commands from input messages to a 
	series of model manipulations. Then it will pass the information accordingly to 
	IView in order to present transformation of the model visually.


-Model: IModel, ISnapshot, IAlbum, IShape 
	An iModel class is added from the version of hw8, as the only object for the Model to 		
	interact with the View and Controller.


-View: 
 
	1.GraphicalView (Swing): 
	Extended from JFrame, this class takes commands from Controller and draws out 
	the shapes. With four buttons, you are able to browse 
	each snapshot with its ID and description.

	2.WebView: This class of View presents all snapshots on an HTML page.


-Utility: 

	Classes implement the buttons.



-Main Function: 

	The application begins by reading user input in PhotoAlbumMain, where it
 	receives their request and translates any text from the input file into 
	the controller. 

			


A graph of My model:

                      Viewer <-- Controller --> Model(SnapShot --> Album --> Shape)