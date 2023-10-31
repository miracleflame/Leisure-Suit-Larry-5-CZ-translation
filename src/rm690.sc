;;; Sierra Script 1.0 - (do not remove this comment)
(script# 690)
(include sci.sh)
(use Main)
(use LLRoom)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm690 0
)

(local
	local0
)
(instance rm690 of LLRoom
	(properties
		picture 1
		style $000c
	)
	
	(method (init)
		(gIconBar disable:)
		(proc958_0 129 690)
		(proc958_0 128 690)
		(proc958_0 135 global175)
		(proc958_0 132 691)
		(super init:)
		(self setScript: sFBI)
	)
)

(instance sFBI of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_25 3 global131 690 0)
				(= seconds 5)
			)
			(1
				(sonarScreen init:)
				(sweep init: setCycle: Fwd)
				(blip init: setCycle: Fwd)
				(global2 drawPic: 690 12)
				(= seconds 5)
			)
			(2
				(gIconBar enable:)
				(proc0_14 690 1 67 -1 20 80 {Inspektor Desmond} 108 self)
			)
			(3 (= seconds 3))
			(4
				(if (proc0_6 20)
					(proc0_14 690 2 67 -1 20 80 {Agent Smith} 108 self)
				else
					(proc0_14 690 3 67 -1 20 80 {Agent Smith} 108 self)
				)
			)
			(5 (= seconds 3))
			(6
				(if gTheNewDialog (gTheNewDialog dispose:))
				(sweep dispose:)
				(blip dispose:)
				(global2 drawPic: 1 6)
				(= seconds 3)
			)
			(7
				(if (proc0_6 20)
					(proc0_14 690 4)
				else
					(proc0_14 690 5)
				)
				(= seconds 3)
			)
			(8
				(global2 newRoom: 200 7)
				(self dispose:)
			)
		)
	)
)

(instance sonarScreen of View
	(properties
		x 163
		y 114
		view 690
		priority 1
		signal $4010
	)
)

(instance sweep of Prop
	(properties
		x 161
		y 86
		view 690
		loop 2
		priority 12
		signal $0010
		cycleSpeed 12
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(cel (= local0 0))
			((not local0) (sonarPing play:) (= local0 1))
		)
	)
)

(instance blip of Prop
	(properties
		x 170
		y 96
		view 690
		loop 1
		priority 12
		signal $0010
		cycleSpeed 12
	)
)

(instance sonarPing of Sound
	(properties
		number 691
	)
)
