package ch.makery.overwatch

import ch.makery.overwatch.model.Game
import ch.makery.overwatch.view.HeroesListDialogController
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.scene.image.Image
import scalafx.stage.{Modality, Stage}


object MainApp extends JFXApp {
  var game: Game = null
  //Transform path of RootLayout.fxml to URI for resource location
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  //Initialize the loader object
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  //Load root layout from fxml file
  loader.load();
  //Retrieve root component BorderPane from the FXML
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  //Initialize stage
  stage = new PrimaryStage {
    title = "Overwatch Game"
    icons += new Image(getClass().getResourceAsStream("/images/overwatchLogo.png"))
    scene = new Scene {
      root = roots
    }
  }

  //Make stage have fixed size
  stage.setResizable(false)

  //Display Home Screen
  def showHome() = {
    val resource = getClass.getResource("view/Home.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  //Display Home when app starts
  showHome()


  //Display Hero Select Screen
  def showHeroSelect() = {
    val resource = getClass.getResource("view/HeroSelect.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  //Display Enemy Select Screen
  def showEnemySelect() = {
    val resource = getClass.getResource("view/EnemySelect.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  //Display Game Screen
  def showGame() = {
    val resource = getClass.getResource("view/Game.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  //Display Game Over Screen
  def showGameOver() = {
    val resource = getClass.getResource("view/GameOver.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  //Display Hero List Dialog
  def showHeroesListDialog() = {
    val resource = getClass.getResourceAsStream("view/HeroesListDialog.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource)
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[HeroesListDialogController#Controller]

    val dialog = new Stage() {
      title = "Heroes List"
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        stylesheets = List(getClass().getResource("view/style.css").toString)
        root = roots2
      }
    }
    control.dialogStage = dialog
    dialog.showAndWait()
  }
}
