;;; Sierra Script 1.0 - (do not remove this comment)
(script# 40)
(include sci.sh)
(use Main)
(use Game)
(use Obj)

(public
	HollywoodRgn 0
)

(instance HollywoodRgn of Rgn
	(properties)
	
	(method (init)
		(if (proc0_6 7) (self setScript: sRemember))
		(super init:)
	)
	
	(method (newRoom newRoomNumber)
		(= keep (proc999_5 newRoomNumber 160 170 180 190))
	)
)

(instance sRemember of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 30))
			(1
				(proc0_14 40 0)
				(proc0_14 40 1)
				(= seconds 120)
			)
			(2
				(proc0_14 40 2)
				(proc0_14 40 3)
				(proc0_14 40 4 67 -1 185)
				(= seconds 120)
			)
			(3
				(proc0_14 40 5)
				(proc0_14 40 6)
				(= seconds 120)
			)
			(4
				(proc0_14 40 7)
				(proc0_14 40 8)
				(proc0_14 40 9)
				(= seconds 120)
			)
			(5
				(proc0_14 40 10)
				(proc0_14 40 11)
				(= seconds 120)
			)
		)
	)
)
