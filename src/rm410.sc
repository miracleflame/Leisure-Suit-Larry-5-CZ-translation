;;; Sierra Script 1.0 - (do not remove this comment)
(script# 410)
(include sci.sh)
(use Main)
(use LLRoom)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm410 0
)

(local
	local0
)
(instance rm410 of LLRoom
	(properties
		picture 410
		east 400
		south 415
		west 420
	)
	
	(method (init)
		(gLarry init: normalize: 411)
		(proc958_0 128 410 411 412)
		(proc958_0 132 410 420)
		(switch gGNumber
			(south
				(gLarry x: 157 y: 125 setLoop: 3 setCel: 0 setCycle: 0)
				(reflection
					init:
					x: 157
					y: 125
					setLoop: 4
					setCel: 0
					setCycle: 0
				)
				(desmond
					init:
					x: 130
					y: 125
					setLoop: 4
					setCel: 0
					setCycle: 0
					signal: 16384
				)
				(self setScript: sCartoon2)
			)
			(else 
				(desmond init: setCycle: Fwd)
				(self setScript: sCartoon)
			)
		)
		(super init:)
		(steam init: setCycle: Fwd)
		(arrow init: setCycle: Fwd)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 415)
			(gLongSong fade: 0 15 12 1 self)
		)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(super newRoom: newRoomNumber)
	)
)

(instance steam of Prop
	(properties
		x 133
		y 162
		view 410
		cel 4
		cycleSpeed 12
		detailLevel 3
	)
)

(instance desmond of Actor
	(properties
		x 31
		y 121
		view 412
		loop 2
	)
)

(instance arrow of Prop
	(properties
		x 286
		y 75
		view 410
		loop 1
		cel 1
		priority 15
		signal $0010
		detailLevel 4
	)
)

(instance reflection of Actor
	(properties
		view 411
		loop 2
		priority 1
		signal $0010
	)
	
	(method (doit)
		(= x (gLarry x?))
		(= y (+ 125 (- 125 (gLarry y?))))
		(= cel (gLarry cel?))
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					x: 262
					y: 111
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 0
					setMotion: MoveTo 226 125 self
				)
				(reflection init:)
				(gLongSong number: 410 flags: 1 setLoop: -1 play:)
			)
			(1
				(proc0_14 410 0 67 -1 15 70 280)
				(gLarry setLoop: 0 setMotion: MoveTo 157 125 self)
				(desmond setScript: sDesmondCartoon)
				(= cycles 20)
			)
			(2
				(proc0_14 410 1 67 -1 20)
				(proc0_14 410 2 67 -1 15 70 280)
			)
			(3
				(gLarry setLoop: 3 setCel: 0 setCycle: 0)
				(reflection setLoop: 4 setCel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance sDesmondCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(desmond setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(desmond
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 130 125 self
				)
			)
			(2
				(desmond setLoop: 4 setCel: 0 setCycle: 0)
				(= seconds 3)
			)
			(3 (global2 newRoom: 415))
		)
	)
)

(instance sCartoon2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 420 flags: 1 setLoop: -1 play:)
				(= ticks 123)
			)
			(1
				(reflection loop: 2)
				(gLarry
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 139 125 self
				)
				(desmond
					setLoop: 1
					setCel: 0
					cycleSpeed: (gLarry cycleSpeed?)
					moveSpeed: (gLarry moveSpeed?)
					setCycle: Walk
					setMotion: MoveTo -10 138
				)
			)
			(2
				(reflection dispose:)
				(gLarry setMotion: MoveTo 0 145 self)
			)
			(3
				(steam dispose:)
				(arrow dispose:)
				(desmond dispose:)
				(gLarry dispose:)
				(DrawPic 1 -32761)
				(proc0_25 4 global128 410 3)
				(= seconds 7)
			)
			(4 (global2 newRoom: 420))
		)
	)
)
