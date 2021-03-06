import net.alasc.symdpoly._

object CHSH extends App {

  object FM extends free.MonoidDef {

    case class A(x: Int) extends Op
    object A extends Hermitian1(0 to 1)

    case class B(y: Int) extends Op
    object B extends Hermitian1(0 to 1)

    val adjoint = {
      case A(x) => A(x)
      case B(y) => B(y)
    }

    val operators = Seq(A, B)
  }

  import FM.{A, B}

  val swapParties = FM.generator {
    case A(i) => B(i)
    case B(i) => A(i)
  }

  val inputSwapA = FM.generator {
    case A(0) => A(1)
    case A(1) => A(0)
    case op => op
  }

  val outputSwapA0 = FM.generator {
    case A(0) => -A(0)
    case op => op
  }

  val QM = quotient.MonoidDef(FM) {
    case (A(x1), A(x2)) if x1 == x2 => Mono.one
    case (B(y1), B(y2)) if y1 == y2 => Mono.one
    case (B(y), A(x)) => A(x) * B(y)
    case (op1, op2) => op1 * op2
  }

  val bellOperator = QM.quotient(A(0)*B(0) + A(0)*B(1) + A(1)*B(0) - A(1)*B(1))

  val ambientGroup = FM.ambientGroup(swapParties, inputSwapA, outputSwapA0)

  val generatingSet = QM.quotient(GSet.onePlus(A, B))

  val L = evaluation.pureStateSelfAdjoint(QM)

  val problem = L(bellOperator).maximize

  val relaxation = problem.symmetricRelaxation(generatingSet, ambientGroup)

  org.apache.log4j.BasicConfigurator.configure
  org.apache.log4j.Logger.getRootLogger.setLevel(org.apache.log4j.Level.INFO)

  println(relaxation.jOptimizerInstance.solve())
  relaxation.writeMomentMatrix("output/chsh_moment_matrix.txt")
  relaxation.writePhaseMatrix("output/chsh_phase_matrix.txt")
  relaxation.writeMomentIndexMatrix("output/chsh_moment_index_matrix.txt")
  relaxation.writeCanonicalMonomials("output/chsh_canonical_monomials.txt")
  relaxation.writeSymmetryGroupDescription("output/chsh_symmetry_group.txt")

  /* UNCOMMENT below if using Mosek (see build.sbt file)

  import net.alasc.symdpoly.mosek._
  relaxation.mosekInstance.writeFile("output/chsh_mosek.cbf")
  relaxation.mosekInstance.writeFile("output/chsh_mosek.task")
  relaxation.mosekInstance.writeFile("output/chsh_mosek.jtask")
   */

  relaxation.sdpaInstance.writeFile("output/chsh_sdpa.dat-s")
  relaxation.sedumiInstance.writeFile("output/chsh_sedumi.mat")
  relaxation.scsInstance.writeFile("output/chsh_scs.mat")
  relaxation.sdpt3Instance.writeFile("output/chsh_sdpt3.mat")

}
