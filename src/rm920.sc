;;; Sierra Script 1.0 - (do not remove this comment)
(script# 920)
(include sci.sh)
(use Main)
(use LLRoom)
(use MCyc)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm920 0
)

(local
	[local0 25] = [0 11 91 86 0 12 92 89 0 13 91 91 0 14 111 98 0 14 153 84 0 14 173 80 -32768]
)
(instance rm920 of LLRoom
	(properties
		picture 920
	)
	
	(method (init)
		(Load rsPIC 1)
		(super init:)
		(gLarry
			init:
			normalize:
			view: 923
			posn: 137 117
			setCycle: 0
			setLoop: 0
			setCel: 0
			setPri: 8
			setStep: 1 1
			illegalBits: 0
			ignoreActors: 1
			hide:
		)
		(crack init: hide:)
		(bars init: hide:)
		(rope init: hide:)
		(chiChi init: setCycle: Fwd)
		(blinds init: setCel: 255)
		(gLongSong number: 920 loop: -1 play:)
		(self setScript: sCartoon)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong stop:)
		(gLongSong2 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_13 900)
				(proc0_22 0)
				(= ticks 90)
			)
			(1
				(proc0_18 gLarry 920 0)
				(= ticks 30)
			)
			(2
				(proc0_14 920 1 80 {Chi Chi})
				(= ticks 90)
			)
			(3 (blinds setCycle: Beg self))
			(4
				(blinds stopUpd:)
				(= ticks 90)
			)
			(5
				(if (!= (chiChi cel?) 1)
					(-- state)
				else
					(gLarry show:)
				)
				(= register (gLarry cycleSpeed?))
				(= cycles 2)
			)
			(6
				(gLarry cycleSpeed: 8 setCycle: End self)
			)
			(7
				(gLongSong2 number: 913 loop: 1 play:)
				(gLarry
					cycleSpeed: register
					setLoop: 1
					setCel: 0
					posn: 85 82
				)
				(rope show: setCycle: End)
				(proc0_18 gLarry 920 2 67 -1 20 108)
				(ShakeScreen 5 1)
				(= ticks 90)
			)
			(8
				(gLarry setStep: 3 6 setMotion: MoveTo 85 124 self)
			)
			(9 (= seconds 3))
			(10 (gLarry setCycle: End self))
			(11 (= seconds 4))
			(12
				(if gTheNewDialog (gTheNewDialog dispose:))
				(blinds setCycle: End self)
			)
			(13
				(Load rsVIEW 924)
				(Load rsVIEW 925)
				(blinds stopUpd:)
				(= seconds 4)
			)
			(14
				(gLarry
					hide:
					setMotion: 0
					view: 924
					cycleSpeed: 12
					setStep: 3 3
					setLoop: 0
					setCel: 0
					posn: 77 93
				)
				(chiChi
					view: 925
					setLoop: 0
					cycleSpeed: 18
					posn: 176 166
					setCycle: Fwd
					setPri: 13
				)
				(bars
					show:
					view: 920
					setLoop: 2
					setCel: 1
					posn: 180 159
					stopUpd:
				)
				(rope
					view: 920
					setLoop: 2
					setCel: 0
					posn: 104 136
					stopUpd:
				)
				(blinds setCycle: Beg self)
			)
			(15
				(blinds stopUpd:)
				(= seconds 4)
			)
			(16
				(proc0_14 920 3 67 -1 15 70 280 80 {Chi Chi})
				(chiChi
					setLoop: 1
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(17
				(chiChi setCel: 0 setCycle: End self)
			)
			(18 (= ticks 120))
			(19
				(gLarry show: setCycle: CT 4 1 self)
			)
			(20
				(proc0_14 920 4 67 -1 20 80 {Chi Chi})
				(gLarry setCycle: CT 10 1 self)
			)
			(21
				(gLongSong2 number: 448 loop: 1 play:)
				(gLarry
					setCel: 11
					cycleSpeed: 12
					setCycle: MCyc @local0 self
				)
			)
			(22
				(gLongSong2 number: 913 loop: 1 play:)
				(proc0_18 gLarry 920 5 80 {You} 67 -1 20 108)
				(gLarry hide:)
				(crack
					show:
					view: 920
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					posn: 244 59
					setPri: 15
					setCycle: End self
				)
			)
			(23
				(ShakeScreen 7 2)
				(crack addToPic:)
				(= seconds 4)
			)
			(24
				(if gTheNewDialog (gTheNewDialog dispose:))
				(blinds setCycle: End self)
			)
			(25
				(Load rsVIEW 921)
				(Load rsVIEW 922)
				(rope dispose:)
				(bars
					setPri: 4
					posn: 131 161
					setCel: 2
					setLoop: 2
					stopUpd:
				)
				(gLarry show: view: 921 posn: 85 124 setLoop: 3 setCel: 0)
				(chiChi
					view: 922
					posn: 102 123
					cycleSpeed: 9
					moveSpeed: 9
					setLoop: 0
					setCel: 0
				)
				(blinds stopUpd:)
				(= seconds 4)
			)
			(26 (blinds setCycle: Beg self))
			(27
				(blinds stopUpd:)
				(= ticks 30)
			)
			(28
				(chiChi
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo 150 (chiChi y?) self
				)
			)
			(29
				(chiChi
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(30 (= ticks 30))
			(31 (chiChi setCycle: End self))
			(32 (= ticks 90))
			(33
				(proc0_14 920 6 80 {Chi Chi} 67 -1 15 70 280)
				(= ticks 90)
			)
			(34
				(gLarry cycleSpeed: 11 moveSpeed: 11 setCycle: End self)
			)
			(35 (= ticks 30))
			(36
				(gLarry
					setCycle: Walk
					setLoop: 0
					setStep: 1 1
					setMotion: MoveTo 116 (gLarry y?) self
				)
			)
			(37
				(gLarry setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(38
				(gLongSong2 number: 914 loop: 1 play:)
				(proc0_18 gLarry 920 7 80 {You} 67 -1 20 108)
				(ShakeScreen 5 2)
				(= ticks 90)
			)
			(39 (gLarry setCycle: End self))
			(40 (= ticks 90))
			(41
				(if gTheNewDialog (gTheNewDialog dispose:))
				(gLongSong2 number: 915 loop: 1 play:)
				(gLarry
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(42 (= seconds 4))
			(43 (blinds setCycle: End self))
			(44 (= ticks 180))
			(45
				(gLarry hide:)
				(chiChi dispose:)
				(bars dispose:)
				(blinds dispose:)
				(DrawPic 1 dpOPEN_EDGECENTER)
				(gLongSong fade:)
				(gLongSong2 fade:)
				(= seconds 3)
			)
			(46
				(proc0_10 40 165)
				(proc0_14 920 8)
				(if (>= ((Inv at: 0) state?) 100)
					(proc0_9 4)
					(proc0_10 20 167)
					(proc0_14 920 9)
					(proc0_14 920 10 67 -1 185)
				else
					(proc0_14 920 11)
				)
				(global2 newRoom: 900)
			)
		)
	)
)

(instance chiChi of Actor
	(properties
		x 128
		y 108
		description {Chi Chi Lambada}
		sightAngle 90
		lookStr {Chi Chi loves doing sexually-explicit gymnastics routines.}
		view 922
		loop 2
		priority 7
		signal $4810
		cycleSpeed 8
	)
)

(instance blinds of Prop
	(properties
		x 128
		y 158
		description {the venetian blinds}
		sightAngle 90
		lookStr {If it weren't for these venetian blinds, we'd all have a perfect view!}
		view 920
		priority 14
		signal $4810
		cycleSpeed 10
	)
)

(instance rope of Prop
	(properties
		x 136
		y 44
		description {the rope}
		sightAngle 90
		lookStr {Hang on to this!}
		view 923
		loop 2
		signal $4810
		cycleSpeed 8
	)
)

(instance bars of View
	(properties
		view 920
		signal $4810
	)
)

(instance crack of Prop
	(properties
		view 920
		signal $4810
	)
)
